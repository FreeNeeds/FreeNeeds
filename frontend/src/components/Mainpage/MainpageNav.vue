<template>
    <div>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item" id="menuBar">

                    </li>
                    <li class="nav-item" id="authGroup">
                        <button id="loginBtn">로그인</button>
                        <button id="logoutBtn">로그아웃</button>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</template>

<script>
    export default {
        mounted() {
            const loginBtn = document.querySelector("#loginBtn")
            const logoutBtn = document.querySelector("#logoutBtn")
            if (this.$store.state.user) {
                logoutBtn.setAttribute('style','display: block')
            } else {
                loginBtn.setAttribute('style','display: block')
            }
        },
    }
</script>