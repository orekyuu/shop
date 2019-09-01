<template>
  <div class="side-menu-box">
    <h2>{{ title }}</h2>
    <ul class="side-menu">
      <li
        v-for="m in menu"
        :key="m.id"
      >
        <a :href="m.href"><i :class="m.icon" />{{ m.text }}</a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'SideMenu',
  props: {
    title: { type: String, required: true },
    menu: { type: Array, required: true }
  }
}
</script>

<style scoped>

</style>
