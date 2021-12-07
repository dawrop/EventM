// import axios from 'axios'
import api from "@/services/api";
import TokenService from "@/services/token.service"

// const API_URL = 'http://localhost:8080/api/auth/';

class AuthService {
    login({ email, password }) {
        return api.post("/auth/signin", {
            email,
            password
        })
            .then(response => {
                if (response.data) {
                    TokenService.setUser(response.data);
                    console.log(TokenService.getUser())
                    console.log(TokenService.getLocalAccessToken())
                    console.log(TokenService.getLocalRefreshToken())
                }

                return response.data
            })
    }

    register({ name, email, password, repeatPassword }) {
        return api.post("/auth/signup", {
            name,
            email,
            password,
            repeatPassword
        });
    }

    logout() {
        TokenService.removeUser()
    }
}

// class AuthService {
//     login(user) {
//         return axios
//             .post(API_URL + 'signin', {
//                 email: user.email,
//                 password: user.password
//         })
//             .then(response => {
//                 if (response.data) {
//                     localStorage.setItem('accessToken', response.data)
//                 }
//
//                 return response.data;
//             })
//     }
//
//     register(user) {
//         return axios.post(API_URL + 'signup', {
//             name: user.name,
//             email: user.email,
//             password: user.password,
//             repeatPassword: user.repeatPassword
//         })
//     }
//
//     logout() {
//         localStorage.removeItem('accessToken')
//     }
// }

export default new AuthService()