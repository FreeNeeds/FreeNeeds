# Req 1. 프라이빗 이더리움 네트워크 구축

## Req 1-1. 가상 머신 구성

**VirtualBox 설치**

**Vagrant 설치**

- vagrant 설치 여부 및 버전 확인

```
vagrant version
```



- 호스트와 가상 머신 간 파일 전송 플러그인 설치

```
vagrant plugin install vagrant-scp
```



**이더리움 네트워크 구축용 VM 2대 생성 - VM name: eth0, eth1**

가상 머신 생성 및 구동

- 원하는 작업 디렉토리에서 Vagrant 초기화(설정 파일 생성)

![image-20220902032434393](assets/image-20220902032434393.png)



- 생성된 Vagrantfile의 내용 수정

<img src="assets/image-20220902032546220.png" alt="image-20220902032546220" style="zoom: 67%;" />



- 가상 머신 구동 명령어 실행

![image-20220902033251363](assets/image-20220902033251363.png)



- 가상 머신 구동 상태 확인

![image-20220902033328836](assets/image-20220902033328836.png)



- 가상 머신 접속(eth0 기준)

![image-20220902033417892](assets/image-20220902033417892.png)





## Req 1-2, 1-3. 이더리움 eth0, eth1 노드 구성

**이더리움 소프트웨어는 Geth1.9(stable) 이상을 사용**

**Geth는 가상 머신 상에서 동작하도록 구축**

**eth0 노드의 경우 RPC API를 호출할 수 있도록 활성화**



- 각 가상머신에 geth 설치

```
sudo apt-get update
sudo apt-get install software-properties-common
sudo add-apt-repository -y ppa:ethereum/ethereum
sudo apt-get install ethereum
geth version
```

