export default class Event {
    constructor(title, description, category, city, address, date, time, picture, hostId) {
        this.title = title
        this.description = description
        this.category = category
        this.city = city
        this.address = address
        this.date = date
        this.time = time
        this.picture = picture
        this.hostId = hostId
    }
}