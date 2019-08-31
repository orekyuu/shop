<template>
  <div class="product-box-list">
    <div
      v-for="product in products"
      :key="product.url"
      class="product-box"
    >
      <img
        :src="product.thumbnail"
        alt=""
        class="product-box-thumbnail"
      >
      <div class="product-name">
        <a :href="product.url">{{ product.name }}</a>
      </div>
      <div class="circle">
        <a :href="product.circle.url">{{ product.circle.name }}</a>
      </div>
      <div class="price">
        {{ product.price }}
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      products: [],
      apiUrl: ''
    }
  },
  mounted () {
    this.apiUrl = this.$el.dataset.apiUrl
    this.products = [
      {
        thumbnail: 'http://localhost:9000/shop-demo/6aa9d6c8-f0ac-43f7-9b49-440902bdd358_%E3%81%84%E3%81%AA%E3%82%80%E5%85%88%E7%94%9F%E6%9C%AC%E8%A1%A8%E7%B4%99.png',
        url: '.',
        name: 'てすと',
        circle: {
          url: '.',
          name: 'サークル名'
        },
        price: '1,570円'
      }
    ]
  }
}
</script>
