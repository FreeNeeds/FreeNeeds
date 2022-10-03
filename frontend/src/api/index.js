import axios from "axios";
//import { API_BASE_URL } from "../config";
const API_BASE_URL = "http://J7b104.p.ssafy.io:8080/api/v1";

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
