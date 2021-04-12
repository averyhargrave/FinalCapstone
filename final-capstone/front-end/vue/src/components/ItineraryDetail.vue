<template>
    <div class="ItineraryDetail">
        <h1>Itinerary {{itinerary.itineraryId}}</h1>
        <button>Edit</button>
        <button>Delete</button>

        <!-- Loop through destinations array and display names after search -->
        <ul>
            <span style="background-color:white;"></span>
                    
            <li v-for="destination in itinerary" v-bind:key="destination.destinationId">
                <router-link :to="{ name: 'ItineraryDetail', params: { id: destination.destinationId}}" class="itineraryDetail">
                    {{ destination.name }}
                </router-link>
            </li>
        </ul>
    </div>
</template>

<script>
import Home from '../components/Home.vue'

export default {
    name: 'Home',
    props: ['itinerary'],
    components : {
        Home
    },
    created() {
        
    },
    data() {
        return {
        }
    }
}
</script>

<style scoped>

</style>
