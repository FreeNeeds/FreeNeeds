// apply.js
import { createInstance } from "./index.js";
import store from "@/store/index.js";
// store.state.user.access_token.token와 같은 형식으로 토큰 가져올 수 있음.
const instance = createInstance();

/** 지원 상태 조회 */
function getApplyStatus(userId, success, fail) {
  instance
    .get(`apply`, {
      params: {
        userId: userId
      }
    })
    .then(success)
    .catch(fail);
}

/** 지원하기 */
function ApplyProject(applyReq, success, fail) {
  instance
    .post(`apply`, applyReq)
    .then(success)
    .catch(fail);
}

/** 지원 상태 변경 */
function ChangeApplyInfo(applyReq, success, fail) {
  instance
    .put(`apply`, applyReq)
    .then(success)
    .catch(fail);
}

/** 지원 취소 */
function cancelApply(applyDeleteReq, success, fail) {
  instance
    .delete(`apply`, applyDeleteReq)
    .then(success)
    .catch(fail);
}

export { cancelApply, ChangeApplyInfo, ApplyProject, getApplyStatus };
