import { createInstance } from "./index.js";
import store from "@/store/index.js";

const instance = createInstance();

function getCompanySign(id, hash) { 
  var signData = "";
  instance
    .get(`/contracts/companySign`, {companyId:id,plainData:hash})
    .then(success => {
      console.log("성공");
      console.log(success)
      signData = success;
    })
    .catch();
  
  return signData;
}

function getUserSign(userId, plainData,success,fail) { 
  instance
    .get(`/contracts/userSign`,userId,plainData)
    .then(success)
    .catch(fail);
}

export default{
  getCompanySign,
  getUserSign
}