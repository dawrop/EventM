export default class UserDetails {
    constructor(id, name, email, avatar) {
        this.id = id
        this.name = name
        this.email = email
        this.avatar = avatar
        this.roles = []
    }
}