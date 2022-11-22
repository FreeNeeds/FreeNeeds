https://web3.storage/

회원가입

API Token 발급

```
npm install web3.storage
```



API Key env 파일에 저장 후 사용

```
npm i dotenv
```

.env 파일 생성

```
WEB3Token = API Token
```



https://www.npmjs.com/package/web3.storage 참고

```javascript
const { Web3Storage, File } = require('web3.storage'); // import 대신. 서버에서 쓰이는 방식
const dotenv =require('dotenv');
const axios = require('axios');
dotenv.config();

// Client: 파일을 올리는 주체
function makeStorageClient(){
    return new Web3Storage({token : process.env.WEB3Token});
}

// file 생성
function makeFileObjects(){
    const data = 'hello world';
    const buffer = Buffer.from(data);
    const file = [new File([buffer], 'newFile.json')];
    return file;
}

// IPFS 업로드
async function storefile(){
    const client = makeStorageClient();
    const res = await client.put(makeFileObjects());
    console.log(res)
    // const files = await res.files();
    // for (const file of files){
    //     console.log(file);
    // }
}

// IPFS 읽어오기
async function retrieveFile(){
    const client = makeStorageClient();
    const res = await client.get('bafybeifvjqhqyh6ik7j4pyqm7p3k4qe3gfzbenj6bgvnjxnkcl3bojnzli') // 올린 파일
    // console.log(res);

    const files = await res.files();
    for(const file of files){
        // console.log(file);
    }
}

// axios로 IPFS 파일 데이터 읽어오기
axios({
    url : "https://bafybeifmtsngcommszj4onlerwf2gaxbtfcsd3ut3qizmql7ysom4woidi.ipfs.w3s.link/%EA%B3%84%EC%95%BD%EC%84%9C.pdf"
}).then(data=>{
    // console.log(data.data);
})

// storefile();
retrieveFile();
```

