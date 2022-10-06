const ESCROWFACTORY_CONTRACT_ABI = JSON.parse(
	`[
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_freelancer",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"name": "createEscrow",
			"outputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_enterprise",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "_freelancer",
					"type": "address"
				}
			],
			"name": "enterprisePayFreelancer",
			"outputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_freelancer",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "_enterprise",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_contractId",
					"type": "uint256"
				},
				{
					"internalType": "string",
					"name": "_hashData",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_enterpriseEncrypt",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_enterprisePublicKey",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_freelancerEncrypt",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_freelancerPublicKey",
					"type": "string"
				}
			],
			"name": "freelancerSignEscrow",
			"outputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"inputs": [
				{
					"internalType": "address",
					"name": "_cashContractAddresss",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "constructor"
		},
		{
			"anonymous": false,
			"inputs": [
				{
					"indexed": true,
					"internalType": "address",
					"name": "freelancer",
					"type": "address"
				},
				{
					"indexed": true,
					"internalType": "address",
					"name": "enterprise",
					"type": "address"
				},
				{
					"indexed": false,
					"internalType": "address",
					"name": "_address",
					"type": "address"
				}
			],
			"name": "CreateEscrow",
			"type": "event"
		},
		{
			"anonymous": false,
			"inputs": [
				{
					"indexed": true,
					"internalType": "uint256",
					"name": "contractId",
					"type": "uint256"
				},
				{
					"indexed": false,
					"internalType": "string",
					"name": "hashData",
					"type": "string"
				},
				{
					"indexed": false,
					"internalType": "string",
					"name": "enterpriseEncrypt",
					"type": "string"
				},
				{
					"indexed": false,
					"internalType": "string",
					"name": "freelancerEncrypt",
					"type": "string"
				},
				{
					"indexed": false,
					"internalType": "string",
					"name": "enterprisePublicKey",
					"type": "string"
				},
				{
					"indexed": false,
					"internalType": "string",
					"name": "freelancerPublicKey",
					"type": "string"
				}
			],
			"name": "NewEscrow",
			"type": "event"
		},
		{
			"anonymous": false,
			"inputs": [
				{
					"indexed": true,
					"internalType": "address",
					"name": "previousOwner",
					"type": "address"
				},
				{
					"indexed": true,
					"internalType": "address",
					"name": "newOwner",
					"type": "address"
				}
			],
			"name": "OwnershipTransferred",
			"type": "event"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "newOwner",
					"type": "address"
				}
			],
			"name": "transferOwnership",
			"outputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "admin",
			"outputs": [
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "cashContractAddress",
			"outputs": [
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				}
			],
			"name": "enterpriseToFreelancerToEscrow",
			"outputs": [
				{
					"internalType": "contract Escrow",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [
				{
					"internalType": "uint256",
					"name": "",
					"type": "uint256"
				}
			],
			"name": "escrows",
			"outputs": [
				{
					"internalType": "contract Escrow",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "owner",
			"outputs": [
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		}
	]`
);


const ESCROW_CONTRACT_ABI = JSON.parse(
	`[
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "string",
					"name": "_hashData",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_enterpriseEncrypt",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_enterprisePublicKey",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_freelancerEncrypt",
					"type": "string"
				},
				{
					"internalType": "string",
					"name": "_freelancerPublicKey",
					"type": "string"
				}
			],
			"name": "inputData",
			"outputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [],
			"name": "pay",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"inputs": [
				{
					"internalType": "address",
					"name": "_contractAddress",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "_enterprise",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "_freelancer",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "constructor"
		},
		{
			"constant": false,
			"inputs": [],
			"name": "withdraw",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "cashContract",
			"outputs": [
				{
					"internalType": "contract CashInterface",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "getamount",
			"outputs": [
				{
					"internalType": "uint256",
					"name": "",
					"type": "uint256"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "getEnterprise",
			"outputs": [
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "getFreelancer",
			"outputs": [
				{
					"internalType": "address",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "getHashData",
			"outputs": [
				{
					"internalType": "string",
					"name": "",
					"type": "string"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		}
	]`
);

const CASH_CONTRACT_ABI = JSON.parse(
	`[
		{
			"inputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "constructor"
		},
		{
			"anonymous": false,
			"inputs": [
				{
					"indexed": true,
					"internalType": "address",
					"name": "owner",
					"type": "address"
				},
				{
					"indexed": true,
					"internalType": "address",
					"name": "spender",
					"type": "address"
				},
				{
					"indexed": false,
					"internalType": "uint256",
					"name": "value",
					"type": "uint256"
				}
			],
			"name": "Approval",
			"type": "event"
		},
		{
			"anonymous": false,
			"inputs": [
				{
					"indexed": true,
					"internalType": "address",
					"name": "from",
					"type": "address"
				},
				{
					"indexed": true,
					"internalType": "address",
					"name": "to",
					"type": "address"
				},
				{
					"indexed": false,
					"internalType": "uint256",
					"name": "value",
					"type": "uint256"
				}
			],
			"name": "Send",
			"type": "event"
		},
		{
			"anonymous": false,
			"inputs": [
				{
					"indexed": true,
					"internalType": "address",
					"name": "from",
					"type": "address"
				},
				{
					"indexed": true,
					"internalType": "address",
					"name": "to",
					"type": "address"
				},
				{
					"indexed": false,
					"internalType": "uint256",
					"name": "value",
					"type": "uint256"
				}
			],
			"name": "Transfer",
			"type": "event"
		},
		{
			"constant": true,
			"inputs": [
				{
					"internalType": "address",
					"name": "_owner",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "_spender",
					"type": "address"
				}
			],
			"name": "allowance",
			"outputs": [
				{
					"internalType": "uint256",
					"name": "",
					"type": "uint256"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_spender",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"name": "approve",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [
				{
					"internalType": "address",
					"name": "_account",
					"type": "address"
				}
			],
			"name": "balanceOf",
			"outputs": [
				{
					"internalType": "uint256",
					"name": "",
					"type": "uint256"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [],
			"name": "buy",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": true,
			"stateMutability": "payable",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "decimals",
			"outputs": [
				{
					"internalType": "uint8",
					"name": "",
					"type": "uint8"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_receiver",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"name": "mint",
			"outputs": [],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "minter",
			"outputs": [
				{
					"internalType": "address payable",
					"name": "",
					"type": "address"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "name",
			"outputs": [
				{
					"internalType": "string",
					"name": "",
					"type": "string"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_sender",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"name": "send",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "symbol",
			"outputs": [
				{
					"internalType": "string",
					"name": "",
					"type": "string"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": true,
			"inputs": [],
			"name": "totalSupply",
			"outputs": [
				{
					"internalType": "uint256",
					"name": "",
					"type": "uint256"
				}
			],
			"payable": false,
			"stateMutability": "view",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_recipient",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"name": "transfer",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		},
		{
			"constant": false,
			"inputs": [
				{
					"internalType": "address",
					"name": "_sender",
					"type": "address"
				},
				{
					"internalType": "address",
					"name": "_recipient",
					"type": "address"
				},
				{
					"internalType": "uint256",
					"name": "_amount",
					"type": "uint256"
				}
			],
			"name": "transferFrom",
			"outputs": [
				{
					"internalType": "bool",
					"name": "",
					"type": "bool"
				}
			],
			"payable": false,
			"stateMutability": "nonpayable",
			"type": "function"
		}
	]`
);

export {
	ESCROWFACTORY_CONTRACT_ABI,
  	ESCROW_CONTRACT_ABI,
	CASH_CONTRACT_ABI,
};