<template> <!-- HTML goes here -->
    <div>
        <h1>Explore Cleveland</h1>
        <div class="destinations">
            <div class="status-message error" v-show="errorMsg != ''">{{errorMsg}}</div>
            <div class="loading" v-if="isLoading">
                <!-- We can put an image here later -->
            </div>
        <div> <!-- We need to figure out how to do a search box up here -->
            <form v-if="!isSubmitted" v-on:submit.prevent="filterDestinations">
                <input v-model="searchTerm" placeholder="Search for a landmark"/>  <!-- two-way binds to searchTerm, attach to API request -->
                 <button>Submit</button>    <!-- might need to add something here -->
            </form>
            <div v-else>
                <!-- Loop through destinations array and display names after search -->
                <ul>
                    <li v-for="destination in destinations" v-bind:key="destination.destination_id">
                        <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destination_id}}">
                            {{ destination.name }}
                        </router-link>
                    </li>
                </ul>
            </div>
            <router-link :to="{ name: 'register' }">Create an account</router-link>
    </div>
        </div>
        </div>
       <!-- <img href="https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-cont[…]F11%2Fskyline-cleveland-ohio-VISITCLEVELAND0917.jpg&q=85"></img> -->
</template>

<script> // Vue goes here
import DestinationService from '../services/DestinationServices';

export default {
    data() {
        return {
            destinations: [],
            errorMsg: '',
            searchTerm: '',
            isSubmitted: false,
            isLoading: false
        }
    },
    created() {

    },
    methods: {
        // Create method that takes the service method and sets response.data to this.destinations
        filterDestinations() {
            // Use services to get destinations that match the searchTerm
            DestinationService.getDestinations().then(response => {
                this.destinations = response.data
                this.destinations.filter(destination => destination.name == this.searchTerm).filter(destination => destination.type == this.searchTerm) // Chain more filters here (OR statements in SQL)
                this.isSubmitted = true;
            })
        }
    }
}
</script>

<style>  /* CSS goes here */

    body {
        background-image: url("https://cleveland-bookkeeping.com/wp-content/uploads/2016/06/Moonrise-over-the-Cleveland-Ohio-skyline-and-Lake-Erie.jpg");
        background-size: cover;
        height: 100%;
    }


    html {
        height: 100%;
    }
    
    div.home {
         display: flex;
        flex-direction: column;
        justify-items: center;
        align-items: center;
    }

    div h1 {
        font-size: 50px;
        color: white;
        font-family: "Lucida Handwriting", cursive;
        font-size: 80px;
    }

    div.destinations {
        display: flex;
        justify-content: center;
    }

    a {
        display: flex;
        justify-content: center;
        font-weight: bold;
        color: white;
    }

    a:hover {
        color: RGB(73, 251, 53);
    }

    input {
        margin: 5px;
    }

    button {
        padding: 2px;
    }

    button:hover {
        color: blue;
    }


</style>