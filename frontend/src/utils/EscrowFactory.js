import Web3 from "web3";
import { ESCROWFACTORY_CONTRACT_ADDRESS } from '@/config';
import { ESCROWFACTORY_CONTRACT_ABI, ESCROW_CONTRACT_ABI } from "@/config/abi";


const web3 = new Web3(window.ethereum);

// 계약 생성
function createEscrow(address,freelancer,amount) { 
  let contract = new web3.eth.Contract(ESCROWFACTORY_CONTRACT_ABI, ESCROWFACTORY_CONTRACT_ADDRESS);
  contract.methods.createEscrow(freelancer,amount)
    .send({ from: address }).then(console.log);
}

// 프리랜서 서명
function freelancerSignEscrow(freelancer, enterprise, contractId, hashData, enterpriseEncrypt, enterprisePublicKey, freelancerEncrypt, freelancerPublicKey) { 
  let contract = new web3.eth.Contract(ESCROWFACTORY_CONTRACT_ABI, ESCROWFACTORY_CONTRACT_ADDRESS);
  contract.methods.freelancerSignEscrow(freelancer, enterprise, contractId, hashData, enterpriseEncrypt, enterprisePublicKey, freelancerEncrypt, freelancerPublicKey)
  .send({ from: freelancer }).then(console.log);
}

// 프리랜서와 기업으로 계약 주소 찾기
function findTxAddress(freelancer, enterprise) { 
  let contract = new web3.eth.Contract(ESCROWFACTORY_CONTRACT_ABI, ESCROWFACTORY_CONTRACT_ADDRESS);
  contract.methods.findTxAddress(freelancer, enterprise).call()
    .then(result => console.log(result));
}

// 기업이 프리랜서에게 정산하기
function enterprisePayFreelancer(enterprise, freelancer) { 
  let contract = new web3.eth.Contract(ESCROWFACTORY_CONTRACT_ABI, ESCROWFACTORY_CONTRACT_ADDRESS);
  contract.methods.enterprisePayFreelancer(enterprise, freelancer)
    .send({ from: enterprise }).then(console.log);
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
function withdraw(enterprise, escrowAddress) {
  let contract = new web3.eth.Contract(ESCROW_CONTRACT_ABI, escrowAddress);
  contract.methods
      .withdraw()
      .send({ from: enterprise }).then(console.log);
}

// 계약상태현황
// 0: 계약생성 1: 계약금동결 2: 기업정산동의 3: 프리랜서인출
function getState(escrowAddress) {
  let contract = new web3.eth.Contract(ESCROW_CONTRACT_ABI, escrowAddress);
  contract.methods
      .getState().call().then(res => console.log(res));
}

// 블록정보 불러오기
function getEvents(_contractId) {
  let contract = new web3.eth.Contract(ESCROWFACTORY_CONTRACT_ABI, ESCROWFACTORY_CONTRACT_ADDRESS);
  return contract.getPastEvents('NewEscrow', { filter:{contractId: _contractId}, fromBlock: 0, toBlock: 'latest'})
}


export { 
  createEscrow,
  freelancerSignEscrow,
  findTxAddress,
  pay,
  agree,
  enterprisePayFreelancer,
  getState,
  getEvents,
}
