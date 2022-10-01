pragma solidity ^0.5.12;

import "./Ownable.sol";

contract EscrowFactory is Ownable{
    
    event CreateEscrow(address indexed freelancer, address indexed enterprise, address _address);
    event NewEscrow(address indexed freelancer, address indexed enterprise, string hashData);

    address public admin;
    address public cashContractAddress;

    Escrow[] public escrows;
    mapping(uint256 => Escrow) public adressToEscrow;
    constructor(address _cashContractAddresss) public {
        admin = msg.sender;
        cashContractAddress = _cashContractAddresss;
    }

    function createEscrow(address _freelancer, uint256 _amount) public {
        Escrow escrow = new Escrow(cashContractAddress, msg.sender, _freelancer, _amount);
        uint256 escrowId = escrows.push(escrow) - 1;
        adressToEscrow[escrowId] = escrow;
        emit CreateEscrow(_freelancer, msg.sender, address(escrow));
    }

    function freelancerSignEscrow(address _freelancer, address _enterprise, string memory _hashData) public {
        for(uint256 i =0; i<escrows.length;i++){
            if(_freelancer == escrows[i].getFreelancer() && _enterprise == escrows[i].getEnterprise()){
                escrows[i].inputHash(_hashData);
                emit NewEscrow(address(escrows[i].getFreelancer), address(escrows[i].getEnterprise), _hashData);
            }
        }
    }

    function findTxAddress(address _freelancer, address _enterprise) public view returns(address){
        for(uint256 i =0; i<escrows.length;i++){
            if(_freelancer == escrows[i].getFreelancer() && _enterprise == escrows[i].getEnterprise()){
                return address(escrows[i]);
            }
        }
        return 0x0000000000000000000000000000000000000000; 
    }

}

contract CashInterface {
    function balanceOf(address _addr) external view returns (uint256 balance);
    function transfer(address _to, uint256 _value) external returns(bool success);
    function transferFrom(address _from, address _to, uint256 _value) external returns(bool success);
    function approve(address _spender, uint256 _amount) external returns (bool);
    function send(address sender, uint amount) external returns (bool);
}

contract Escrow {
    CashInterface public cashContract;

    enum State {Created, Paid, Agreed, Withdraw}
    State public state;

    string private hashData;
    address private enterprise;
    address private  freelancer;
    uint256 private amount;

    modifier onlyEnterprise{
        require(msg.sender == enterprise);
        _;
    }

    modifier onlyFreelancer{
        require(msg.sender == freelancer);
        _;
    }

    //기업, 프리랜서 주소 입력
    constructor(address _contractAddress, address _enterprise, address _freelancer, uint256 _amount) public {
        cashContract = CashInterface(_contractAddress);
        enterprise = _enterprise;
        freelancer = _freelancer;
        amount = _amount;
    }

    function inputHash(string memory _hashData) public {
        hashData = _hashData;
    }

    function getFreelancer() view external returns (address){
        return freelancer;
    }

    function getEnterprise() view external returns(address){
        return enterprise;
    }

    function getHashData() view external returns(string memory){
        return hashData;
    }

    function pay() public onlyEnterprise returns (bool){
        require(state == State.Created);
        cashContract.send(enterprise, amount);
        state = State.Paid;
        return true;
    }

    function agree() public onlyEnterprise returns (bool){
        require(state == State.Paid);
        state = State.Agreed;
        return true;
    }

    function withdraw() public onlyFreelancer returns (bool){
        require(state == State.Agreed);
        cashContract.transfer(freelancer, amount);
        state = State.Withdraw;
        return true;
    }

}