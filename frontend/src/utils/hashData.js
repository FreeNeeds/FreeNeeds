import crypto from "crypto";

function getHashData(data) { 
  var hash = crypto.createHash('sha256');
  var result = hash.update(data).digest('hex');
  // console.log("결과값");
  // console.log(result);
  return result;
}


export default{ 
  getHashData,
}

