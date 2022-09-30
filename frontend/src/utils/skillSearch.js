const skills = ["Java","Javascript","HTML","JQuery","CSS","React.js","Vue.js","Node.js",
"Python","JSP","PHP","Django","Swift","C","C++","C#","Objective-C","Kotlin","Spring","MySQL","Mybatis","Redux","React-Native",
"Oracle","JPA","PostgreSQL","CI/CD","Angular.js","MariaDB","MongoDB","Redis","Firebase","UI/UX","Photoshop","Linux",".NET","Typescript","ASP.NET","MVVM",
"MSSQL","Flutter","Docker","Kubernetes","Jenkins","Nginx","Unity","AWS","Nexacro","MFC","Web3.js","Solidity"]

skills.sort()

const searchSkillFunc = (payload) => {
  let maxRes = 0
  let strRes = []
  for (const sk of skills) {
    let dp = []
    let skill = ""
    for (let i = 0; i < sk.length; i++){
      skill += sk[i]
    }
    skill = skill.toUpperCase()
    payload = payload.toUpperCase()
    for (let i = 0; i < payload.length + 1; i++){
      let tmp = []
      for (let j = 0; j < skill.length + 1; j++){
        tmp.push(0)
      }
      dp.push(tmp)
    }

    for (let i = 1; i < payload.length + 1; i++){
      for (let j = 1; j < skill.length + 1; j++){
        if (payload[i-1] === skill[j-1]){
          dp[i][j] = dp[i-1][j-1] + 1
        } else {
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
        }
      }
    }
    let max_ = 0
    for (let i = 0; i < payload.length + 1; i++){
      for (let j = 0; j < skill.length + 1; j++){
        if (dp[i][j] > max_) {
          max_ = dp[i][j]
        }
      }
    }
    if (sk === 'ASP.NET') console.log(max_,maxRes)
    if (max_ > maxRes) {
      strRes = [sk]
      maxRes = max_
    } else if (max_ === maxRes) {
      strRes.push(sk)
    }
  }
  return strRes
}

export {
  searchSkillFunc,
  skills
}