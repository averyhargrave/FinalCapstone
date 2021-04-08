<template>
    <div class="DestinationDetail">
        <h1>{{destination.name}}</h1>
        <h2>{{destination.description}}</h2>
        <a :href="destination.website">{{destination.website}}</a>

        <img :src="destination.image" alt="Landmark Image">
    </div>
</template>

<script>
import DestinationServices from '../services/DestinationServices'

export default {
    created() {
        DestinationServices.getADestination(this.$route.params.id).then(response => {
            this.destination = response.data[0]
            console.log(this.destination)
        });
    },
    data() {
        return {
            destination: {}
        }

        
    }
}

</script>

<style scoped>
h1 {
color: black;
}



</style>