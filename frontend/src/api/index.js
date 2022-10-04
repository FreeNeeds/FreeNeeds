import axios from "axios";
//import { API_BASE_URL } from "../config";
<<<<<<< HEAD
const API_BASE_URL = "https://J7b104.p.ssafy.io/api/v1";
=======

const API_BASE_URL = "http://localhost:8080/api/v1";
>>>>>>> ca028a09e5b69ec67e81a8203c799b947e4386c6

function createInstance() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      "Content-Type": "application/json"
    }
  });
  return instance;
}

export { createInstance };
