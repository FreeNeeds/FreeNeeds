// import { BLOCKCHAIN_URL } from "@/config";
import { EscrowFactoryAddress } from "@/config";
import { EscrowFactoryABI,ESCROW_CONTRACT_ABI, } from "@/config/abi";
import Web3 from "web3";

const web3 = new Web3(window.ethereum);


function createEscrow(address,freelancer,amount) { 
  let contract = new web3.eth.Contract(EscrowFactoryABI, EscrowFactoryAddress);
  contract.methods.createEscrow(freelancer,amount)
    .send({ from: address }).then(console.log);
}

function freelancerSignEscrow(address,freelancer, enterprise, hashData) { 
  let contract = new web3.eth.Contract(EscrowFactoryABI, EscrowFactoryAddress);
  contract.methods.freelancerSignEscrow(freelancer, enterprise, hashData)
  .send({ from: address }).then(console.log);
}

function findTxAddress(freelancer, enterprise) { 
  let contract = new web3.eth.Contract(EscrowFactoryABI, EscrowFactoryAddress);
  contract.methods.findTxAddress(freelancer, enterprise).call()
    .then(result => console.log(result));
}

// 계약금 동결
function pay(enterprise, escrowAddress) {
  let contract = new web3.eth.Contract(ESCROW_CONTRACT_ABI, escrowAddress);
  contract.methods
      .pay()
      .send({ from: enterprise }).then(console.log);
}

// 기업 계약 정산 동의
function agree(enterprise, escrowAddress) {
  let contract = new web3.eth.Contract(ESCROW_CONTRACT_ABI, escrowAddress);
  contract.methods
      .agree()
      .send({ from: enterprise }).then(console.log);
}

// 프리랜서 인출
function withdraw(freelancer, escrowAddress) {
  let contract = new web3.eth.Contract(ESCROW_CONTRACT_ABI, escrowAddress);
  contract.methods
      .withdraw()
      .send({ from: freelancer }).then(console.log);
}


export { 
  createEscrow,
  freelancerSignEscrow,
  findTxAddress,
  pay,
  agree,
  withdraw
}
