<template>
  <div class="product-box-list">
    <div
      v-for="product in products"
      :key="product.url"
      class="product-box"
    >
      <img
        :src="product.thumbnail.url"
        alt=""
        class="product-box-thumbnail"
      >
      <div class="product-name">
        <a :href="product.url">{{ product.name }}</a>
      </div>
      <div class="circle">
        <a href="/home">サークル名がここに入る</a>
      </div>
      <div class="price">
        {{ product.taxIncludedPrice }}円
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    products: Array
  }
}
</script>
