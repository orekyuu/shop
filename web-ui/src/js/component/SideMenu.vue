<template>
    <div class="side-menu-box">
        <h2>{{title}}</h2>
        <ul class="side-menu">
            <li v-for="m in menu" :key="m.id"><a :href="m.href"><i :class="m.icon"></i>{{ m.text }}</a></li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "SideMenu",
        props: {
            title: String,
            menu: Array
        }
    }
</script>

<style scoped>

</style>