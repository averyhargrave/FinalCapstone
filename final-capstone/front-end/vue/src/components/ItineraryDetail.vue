<template>
    <div class="ItineraryDetail">
        <h1>Itinerary of {{itinerary.date}}</h1>
        <button>Edit</button>
        <button>Delete</button>

        <!-- Loop through destinations array and display names after search -->
        <ul>        
            <li v-for="destination in destinations" v-bind:key="destination.destinationId">
                <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destinationId}}" class="destinationDetail">
                    {{ destination.name }}
                </router-link>
            </li>
        </ul>
    </div>
</template>

<script>
import Home from '../components/Home.vue'
import ItineraryServices from '../services/ItineraryServices.js'

export default {
    name: 'Home',
    created() {
        ItineraryServices.getItineraryByItineraryId(this.$route.params.id).then(response => {
            this.itinerary = response.data;
        });
        ItineraryServices.viewDestinationsByItineraryId(this.$route.params.id).then(response => {
            this.destinations = response.data;
        });
    },
    data() {
        return {
            itinerary: [],
            destinations: []
        }
    }
}
</script>

<style scoped>

</style>
