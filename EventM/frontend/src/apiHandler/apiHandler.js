import axios from "axios";
import authHeader from "@/services/auth-header";

const apiUrl = "http://localhost:8080/"

export class Api {
    static get(url) {
        return axios.get(apiUrl + url, { headers: authHeader() })
    }

    static post(url, body) {
        return axios.post(apiUrl + url, body, { headers: authHeader() })
    }
}