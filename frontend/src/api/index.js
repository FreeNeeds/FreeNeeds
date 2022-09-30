import axios from "axios";
//import { API_BASE_URL } from "../config";


const API_BASE_URL = "http://localhost:8000/api/v1";


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
