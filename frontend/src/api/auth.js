// auth.js
import { createInstance } from "./index.js";

const instance = createInstance();

/** 기업로그인 */
function companyLogin(loginInfo, success, fail) {
  instance
    .post(`/auth/company/login`, loginInfo)
    .then(success)
    .catch(fail);
}

/** 유저 로그인 */
function freelancerLogin(loginInfo, success, fail) {
  instance
    .post(`/auth/user/login`, loginInfo)
    .then(success)
    .catch(fail);
}

export { companyLogin, freelancerLogin };
