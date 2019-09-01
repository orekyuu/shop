<template>
  <div>
    <FloorHeader />
    <FloorTab />
    <ThreeColumn>
      <template v-slot:left>
        <SideMenu title="サイドメニュー" :menu="[{ href: '.', icon: 'fas fa-star', text: 'メニュー1' },{ href: '.', icon: 'fas fa-star', text: 'メニュー1' }, { href: '.', icon: 'fas fa-star', text: 'メニュー1' }]"/>
        <div class="side-menu-box">
          <h2>作品特集</h2>
        </div>
      </template>
      <template v-slot:center>
        <section>
          <h1 class="section-title">
            新着作品
          </h1>
          <section>
            <h1 class="section-title">
              ゲーム
            </h1>
            <ProductList :products="newProducts"/>
          </section>
        </section>
      </template>
      <template v-slot:right>
        <div class="side-menu-box">
          <h2>週間ランキング</h2>
        </div>
      </template>
    </ThreeColumn>
  </div>
</template>

<script>
import FloorHeader from '../component/FloorHeader'
import FloorTab from '../component/FloorTab'
import ProductList from "../component/ProductList";
import ThreeColumn from "../layout/ThreeColumn";
import SideMenu from "../component/SideMenu";
export default {
  name: 'Home',
  components: {SideMenu, ThreeColumn, FloorTab, FloorHeader, ProductList },
  data() {
    return {
      newProducts: window.initialData.newProducts
    }
  }
}
</script>

<style scoped>

</style>
