import axios from 'axios';
export default {

createItinerary() {
    return axios.post(`/createItinerary`);
},

getItineraryById(userId) {
    return axios.get(`/itineraryUser/${userId}`);
},

deleteItinerary(itineraryId) {
    return axios.delete(`/deleteItinerary/${itineraryId}`)
}
}