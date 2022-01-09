export default {
    computed: {
        filteredEvents: function () {
            return this.events.filter((event) => {
                return event.title.includes(this.search) ||
                    event.category.includes(this.search) ||
                    event.city.includes(this.search) ||
                    event.hostName.includes(this.search)
            })
        }
    }
}