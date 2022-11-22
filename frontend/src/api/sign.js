import { createInstance } from "./index.js";
import store from "@/store/index.js";

const instance = createInstance();

async function getCompanySign(id, hash) {
  var signData = "";
  await instance
    .get(`/contracts/companySign`, {
      params: { companyId: id, plainData: hash }
    })
    .then(success => {
      // console.log("기업 암호화 성공");
      // console.log(success)
      signData = success.data;
    })
    .catch(fail => {
      console.log(fail);
    });

  return signData;
}

async function getUserSign(id,hash) {
  var signData = "";
  await instance
    .get(`/contracts/userSign`,{
      params: { userId: id, plainData: hash }
    })
    .then(success => {
      // console.log("유저 암호화 성공");
      // console.log(success);
      signData = success.data;
    })
    .catch(fail => {
      console.log(fail)
    });
  return signData;
}

export default{
  getCompanySign,
  getUserSign
}
