import instance from "./api"
import TokenService from "./token.service"

const setup = (store) => {
    instance.interceptors.request.use(
        (config) => {
            const token = TokenService.getLocalAccessToken();
            if (token) {
                config.headers["Authorization"] = 'Bearer ' + token;
            }

            return config
        },
        (error => {
            return Promise.reject(error)
        })
    )

    instance.interceptors.response.use(
        (res) => {
            return res
        },
        async error => {
            const originalConfig = error.config

            if (originalConfig.url !== "auth/login" && error.response) {
                if (error.response.status === 401 && !originalConfig._retry) {
                    originalConfig._retry = true

                    try {
                        const rs = await instance.post("/auth/refreshtoken", {
                            refreshToken: TokenService.getLocalRefreshToken(),
                        });

                        const { accessToken } = rs.data;

                        store.dispatch('auth/refreshToken', accessToken);
                        TokenService.updateLocalAccessToken(accessToken);

                        return instance(originalConfig);
                    } catch (_error) {
                        return Promise.reject(_error);
                    }
                }
            }
            return Promise.reject(error)
        }
    )
}

export default setup