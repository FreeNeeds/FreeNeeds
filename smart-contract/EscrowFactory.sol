pragma solidity ^0.5.12;

import "./Ownable.sol";

contract EscrowFactory is Ownable{
    
    event CreateEscrow(address indexed freelancer, address indexed enterprise, address _address);
    event NewEscrow(address indexed freelancer, address indexed enterprise, string hashData);

    address public admin;
    address public cashContractAddress;

    Escrow[] public escrows;
    mapping(address => mapping(address => Escrow)) public enterpriseToFreelancerToEscrow;
    

    constructor(address _cashContractAddresss) public {
        admin = msg.sender;
        cashContractAddress = _cashContractAddresss;
    }

    function createEscrow(address _freelancer, uint256 _amount) public {
        Escrow escrow = new Escrow(cashContractAddress, msg.sender, _freelancer, _amount);
        escrow.pay();
        escrows.push(escrow);
        enterpriseToFreelancerToEscrow[msg.sender][_freelancer] = escrow;
        emit CreateEscrow(_freelancer, msg.sender, address(escrow));
    }

    function freelancerSignEscrow(address _freelancer, address _enterprise, string memory _hashData) public {
        enterpriseToFreelancerToEscrow[_enterprise][_freelancer].inputHash(_hashData);
        emit NewEscrow(_freelancer, _enterprise, _hashData);
    }

    function getEnterpriseToFreelancerToEscrow(address _enterprise, address _freelancer) public view returns(address) {
      return address(enterpriseToFreelancerToEscrow[_enterprise][_freelancer]);
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

    string private hashData;
    address private enterprise;
    address private freelancer;
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

    function getamount() view external returns(uint256){
        return amount;
    }


    function pay() public returns (bool){
        cashContract.send(enterprise, amount);
        return true;
    }

    function withdraw() public returns (bool){
        cashContract.transfer(freelancer, amount);
        return true;
    }

}