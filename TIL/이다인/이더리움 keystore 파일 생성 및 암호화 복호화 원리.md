- 이더리움 플랫폼에서는 본인을 확인하는 수단으로 KetStore 파일을 사용
- 사용자는 KeyStore 파일을 생성할 때 입력했던 비밀번호를 통해 유효한 사용자임을 인증하고 계좌에 접근 가능



**KeyStore 파일이란?**

- 이더리움 Private Key의 암호화된 버전
- KeyStore 파일은 특정 계좌에 대해 본인을 인증하는 수단
- 트랜잭션 서명하기 위해 사용

=> KeyStore 파일에 암호를 입력하여 복호화 과정 후 Private Key를 도출하여 사용



**KeyStore.json**

```json
{"address":"06136abcb7a02ad12839073053c04f5d8bccb308",
 "crypto":{
     "cipher":"aes-128-ctr",
     "ciphertext":"f6994ca65c5a4543cc8d1c91b076e8237ba7026ac2cb869efc59a1791aa0579b",
     "cipherparams":{"iv":"942ec26e87270ad45b347472ae05365b"},
     "kdf":"scrypt",
     "kdfparams":{
         "dklen":32,
         "n":262144,
         "p":1,
         "r":8,
         "salt":"0eeafb2fa2839c01d0c903d529404a13bb1b9e9f028b31a51be863b22e656f27"},
     "mac":"c6c515455c2004cc3209c6669003136d0eb136405f0a40ada7895196279108a5"},
 "id":"42100e0c-b011-406d-973d-c5913a5db0e9",
 "version":3}
```

