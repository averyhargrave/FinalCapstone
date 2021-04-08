import axios from 'axios';
export default {

createItinerary() {
    return axios.post(`/create/itinerary`);
},

getItineraryById(userId) {
    return axios.get(`/itineraryByUser/${userId}`);
},

deleteItinerary(itineraryId) {
    return axios.delete(`/deleteItinerary/${itineraryId}`)
}
}