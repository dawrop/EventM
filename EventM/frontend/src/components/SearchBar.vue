<template>
    <div class="input-group md-form form-sm form-2 pl-0">
        <input class="form-control my-0 py-1 lime-border" type="text" v-model="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
            <span class="input-group-text lime lighten-2" id="basic-text1">
                <i class="fa fa-search text-grey" aria-hidden="true"/>
            </span>
        </div>
    </div>
</template>

<script>
export default {
    name: "SearchBar",
    data() {
        return {
            search: ''
        }
    },
}
</script>

<style scoped>

</style>