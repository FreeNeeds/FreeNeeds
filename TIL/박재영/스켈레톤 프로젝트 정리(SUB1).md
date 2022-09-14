# 스켈레톤 프로젝트 정리(SUB1)

## 이더리움

- 이더리움은 블록체인 기술을 기반으로 하는 분산 컴퓨팅 플랫폼이다.
- 이더리움의 가장 큰 특징은 스마트 컨트랙트의 기능을 새롭게 확장했다는 것이다.
- 스마트 컨트랙트는 비트코인에 최초로 적용되었다. 하지만 고도화되지 않았기 때문에 크게 주목을 받지는 못했다.
- 이더리움은 스마트 컨트랙트만을 위한 언어(solidity, LLL 등)을 개발하였고 EVM(Ethereum Virtual Machine)도 제작하였다.

### 1세대 블록체인과 이더리움의 차이점

1. 암호 해시함수

- 비트코인에서는 SHA 계열의 함수를 사용하지만 이더리움은 Ethash라는 KECCACK기반의 해시 알고리즘을 개발하여 사용한다.
- 이를 이용해 ASIC(Application Specific Integrated Circuit)저항성을 향상하고 채굴의 중앙화를 해소한다.

2. Modified Merkle Patricia Trie(MPT)

- MPT는 트랜잭션 데이터의 위변조 감지 및 스마트 컨트랙트 관련 상태 정보를 저장, 관리하기 위한 기술이다.
- 이를 위해 1세대 블록체인에서는 해시값들의 트리인 머클 트리를 이용했다.
- 이더리움에서는 머클트리를 Patricia Trie와 접목시킨 MPT를 사용하여 상태정보를 key-value형식으로 저장하며 관리한다.

3. 암호화폐 관리 기술

- 비트코인은 '소비되지 않은 거래 출력(잔액)'UTXO(Unspent Transaction Output) 을 기반으로 한다.
- 반면에 이더리움은 '사용자 계정'에 기반하여 암호 화폐를 관리한다.

### Geth(Go-Ethereum)

- Geth는 이더리움 클라이언트 중 Go언어로 개발된 버전이다.
- Geth프로그램은 이더리움에서 제공하는 다양한 API를 사용해볼 수 있으며 메인넷, 테스트넷 등과의 연동을 쉽게 할 수 있도록 편의성을 제공한다.

- Ubuntu에서 Geth를 설치하는 방법

```
sudo apt-get update
sudo apt-get install software-properties-common
sudo add-apt-repository -y ppa:ethereum/ehereum
sudo apt-get install ethereum
geth version
```

### Web3.js

- Web3.js는 이더리움 생태계에 다양한 요청을 처리할 수 있게 하는 JavaScript API 라이브러리이다.
- Geth는 HTTP 기반의 JSON RPC를 지원하고 있으며, Web3.js 또한 내부적으로 JSON RPC를 사용하고 있다.
- Web3.js는 JavaScript인터페이스만으로도 이더리움 노드들과 상호 작용을 가능하게 한다.

### Solidity

- Solidity는 이더리움에0서 개발한 스마트 컨트랙트 개발 언어이다.
- Serpent, LLL로도 스마트 컨트랙트를 작성할 수 있으나 Solidity가 가장 널리 사용되고 있다.
- Solidity 스마트 컨트랙트는 컴파일러를 통해 바이트 코드로 변환되어 이더리움 가상 머신 위에서 동작하게 된다.

- Solidity에는 uint/int, bool, string, bytes등 다른 언어에서도 지원하는 기본 자료형을 지원하지만 부동 소수점(floating point number)은 없다.
- 정수형의 경우 비교 연산자, 비트 연산자, 쉬프트 연산자, 모듈로, 지수 등의 수학 연산자 사용이 가능하며 논리형 역시 논리 연산자 사용이 가능하다.
- Solidity에는 이더리움의 주소를 나타내는 20바이트 길이를 저장할 수 있는 address자료형이 존재한다. 이 밖에 레퍼런스 타입의 구조체, 배열(고정 크기, 유동 크기), 열거형, 매핑형(mapping)을 사용할 수 있다.
- 매핑형은 해시 테이블(Hash Table)과 같으며 Key에는 기본형을 Value에는 사용자 지정 타입까지 지정할 수 있다.
- 코드에 명시되어 있지 않아도 모든 함수에서 이용 가능한 전역 변수, 전역 함수가 존재하는데 require(), assert(), revert()등의 에러 처리 함수와 msg.sender, msg.value 등의 전역 변수가 특히 많이 쓰인다.

### VirtualBox
* VirtualBox는 가상화를 위한 소프트웨어로, 다양한 운영체제에서 사용할 수 있다.
* 가상화는 컴퓨터 리소스의 추상화를 일컫는 광범위한 용어이다.
* VirtualBox의 경우 가상화의 여러 종류 중 하드웨어 가상화로 분류되는데 Host OS위에 Guest OS를 만들어 독립적인 환경을 구성할 수 있다.
* 이 외에도 Hyper-V, VMware Player, Parallels Desktop등의 가상화 소프트웨어가 있다.
  

### Vagrant
* Vagrant는 가상 머신 프로비저닝(Provisioning)도구이다.
* 간단한 스크립트를 작성하여 VirtualBox, Hyper-V등 다양한 가상머신을 쉽게 생성, 수정, 삭제, 관리할 수 있다.

```
vagrant                     //해당 경로에 Vagrant 설정 파일 생성
vagrant up<args>            //args에 해당하는 가상머신 구동
vagrant halt<args>          //args에 해당하는 가상머신 정지
vagrant destroy<args>       //args에 해당하는 가상머신 삭제
vagrant ssh<args>           //args에 해당하는 가상머신 접속
vagrant sst-config<args>    //args에 해당하는 가상머신 SSH 설정 확인
vagrant status              //가상머신 상태 정보 출력(해당 경로)
vagrant global-status       //가상머신 상태 정보 출력(전체 폴더)
vagrant help                //vagrant관련 명령어 정보 출력
```

### Remix IDE
* Remix IDE는 별도의 설치 없이 웹 브라우저 상에서 이용 가능한 이더리움 스마트 컨트랙트 개발 도구이다.
* 다양한 버전의 Solidity버전을 컴파일할 수 있고 Javascript VM을 통해 스마트 컨트랙트를 사전 테스트할 수 있다.
* 테스트넷과의 연동을 통한 배포 및 호출 등을 쉽게 진행할 수 있다.
* 스마트 컨트랙트에 소요되는 Gas를 미리 예상해 볼 수 있고 UI를 통한 손쉬운 호출로 이더리움 스마트 컨트랙트를 개발하기에 편리하다.

### Metamask
* Metamask는 이더리움 지갑 프로그램의 일종이다.
* 크롬 확장 프로그램으로 설치되며 편리하게 이용할 수 있다.
* Metamask 이더리움 메인넷은 물론이고 테스트넷, 로컬 환경 및 별도로 구축한 이더리움 네트워크와도 연동이 가능하여 활용도가 높다.
* 지갑 프로그램은 블록체인과 사용자가 만나는 접점 중 하나이다. 
* 지갑 프로그램에서는 블록체인 계정 주소의 관리, 비밀키 관리 및 거래 내역 조회 등을 지원하며 암호화폐 거래 및 스마트 컨트랙트 배포가 가능하다.

### 가상 머신 구성
1. Virtual Box 설치
2. Vagrant 설치
   
* Vagrant 설치 여부 및 버전 확인
  
![vagrant버전](./img/Vagrant%EB%B2%84%EC%A0%84PNG.PNG)

* 호스트와 가상 머신 간 파일 전송 플러그인 설치

![플러그인 설치](./img/%ED%94%8C%EB%9F%AC%EA%B7%B8%EC%9D%B8%20%EC%84%A4%EC%B9%98.PNG)

* 가상 머신 생성 및 구동
  1. 작업 디렉토리에서 vagrant 초기화
  ```
  vagrant init
  ```

  2. 생성된 Vagrantfile 내용 수정 
  
  ![Vagrantfile내용 수정](./img/Vargrantfile%EB%82%B4%EC%9A%A9%20%EC%88%98%EC%A0%95.PNG) 

  3. 가상 머신 구동 명령어 실행
  
  ![가상머신구동](./img/%EA%B0%80%EC%83%81%EB%A8%B8%EC%8B%A0%EA%B5%AC%EB%8F%99.PNG) 

  4. 가상 머신 구동 상태 확인
  
  ![가상머신구동상태확인](./img/%EA%B0%80%EC%83%81%EB%A8%B8%EC%8B%A0%EA%B5%AC%EB%8F%99%EC%83%81%ED%83%9C%ED%99%95%EC%9D%B8.PNG)

  5. 가상 머신 접속
  
  ![가상머신접속](./img/%EA%B0%80%EC%83%81%EB%A8%B8%EC%8B%A0%EC%A0%91%EC%86%8D.PNG)
 
## 과제

### 1. 프라이빗 이더리움 네트워크 구축
* 1-1 가상 머신 구성
  * VirtualBox 설치
  * Vagrant 설치

* 1-2 이더리움 eth0 노드 구성
      
  * 이더리움 설치
    ```
    sudo apt-get update
    sudo apt-get install software-properties-common
    sudo add-apt-repository -y ppa:ethereum/ethereum
    sudo apt-get install ethereum
    ```

  * Genesis 블록파일 설정
   ![Genesis 블록파일 생성](./img/Genesis%EB%B8%94%EB%A1%9D%ED%8C%8C%EC%9D%BC%20%EC%83%9D%EC%84%B1.PNG)

  * eth0 노드 설정
    ```
    geth --networkid 921 --maxpeers 2 --datadir ~/dev/eth_localdata --allow-insecure-unlock --port 30303 --http --http.port 8545 --http.addr 0.0.0.0 --http.corsdomain "*" --http.api "admin,net,miner,eth,rpc,web3,txpool,debug,personal" --miner.threads 1 
    ```
* 1-3 이더리움 eth1 노드 구성
    
    * 이더리움 설치
    ```
    sudo apt-get update
    sudo apt-get install software-properties-common
    sudo add-apt-repository -y ppa:ethereum/ethereum
    sudo apt-get install ethereum
    ```

    * eth1 노드 설정
    ```
    geth --networkid 921 --maxpeers 2 --datadir ~/dev/eth_localdata --allow-insecure-unlock --port 30303 --http --http.port 8545 --http.addr localhost --http.corsdomain "*" --miner.threads 1
    ```

### 2. 이더리움 계정생성

* 2-1 계정 생성
  1. 계정 생성
```
personal.newAccount(패스워드)
```
![계정 생성](./img/%EA%B3%84%EC%A0%95%20%EC%83%9D%EC%84%B1.PNG)
  2. 계정 확인
```
eth.accounts
```


* 2-2 코인베이스 설정

  1. 코인베이스 생성
```
eth.coinbase
```

  ![코인베이스 생성](./img/%EC%BD%94%EC%9D%B8%EB%B2%A0%EC%9D%B4%EC%8A%A4%20%EC%83%9D%EC%84%B1.PNG)


  1. 코인베이스 계정 주소 변경
```
miner.setEtherbase("계정 주소")
```

  ![코인베이스 계정 주소 변경](./img/%EC%BD%94%EC%9D%B8%EB%B2%A0%EC%9D%B4%EC%8A%A4%20%EA%B3%84%EC%A0%95%20%EC%A3%BC%EC%86%8C%20%EB%B3%80%EA%B2%BD.PNG)

* 2-3 마이닝 시작

  1. 마이닝 시작 명령어
   ```
   miner.start(1)
   ```

  2. 마이닝 진행 상태 확인
   ```
   eth.mining
   ```
  3. 마이닝 종료
  ```
  miner.stop()
  ```

* 마이닝 결과 확인
  1. 계정 잔액 확인
   ```
   eth.getBalance(eth.accounts[0])
   ```
  2. 생성된 블록 수 조회
   ```
   eth.blockNumber
   ```
  3. 블록 상세정보 조회
   ```
   eth.getBlock(eth.blockNumber)
   ```

### 3. 이더리움 트랜잭션 생성

* 3-1 트랜잭션 생성
