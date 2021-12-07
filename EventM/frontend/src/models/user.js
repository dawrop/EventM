export default class User {
    constructor(name, email, password, repeatPassword) {
        this.name = name
        this.email = email
        this.password = password
        this.repeatPassword = repeatPassword
        this.roles = []
    }
}