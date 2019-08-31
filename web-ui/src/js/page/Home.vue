<template>
    <div>
        <FloorHeader/>
        <FloorTab/>
        <div class="floor-content-wrapper">
            <div class="left">
                <div class="side-menu-box">
                    <h2>サイドメニュー</h2>
                    <ul class="side-menu">
                        <li><a href=""><i class="fas fa-star"></i> メニュー1</a></li>
                        <li><a href=""><i class="fas fa-star"></i>メニュー2</a></li>
                        <li><a href=""><i class="fas fa-star"></i>メニュー3</a></li>
                    </ul>
                </div>
                <div class="side-menu-box">
                    <h2>作品特集</h2>
                </div>
            </div>
            <div class="center">
                <section>
                    <h1 class="section-title">新着作品</h1>
                    <section>
                        <h1 class="section-title">ゲーム</h1>
                        <div class="product-list"></div>
                    </section>
                </section>
            </div>
            <div class="right">
                <div class="side-menu-box">
                    <h2>週間ランキング</h2>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import FloorHeader from "../component/FloorHeader";
    import FloorTab from "../component/FloorTab";
    export default {
        name: "Home",
        components: {FloorTab, FloorHeader}
    }
</script>

<style scoped>

</style>