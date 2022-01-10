import Login from '../views/authorization/Login.vue'
import SignUp from '../views/authorization/SignUp.vue'
import ForgotPassword from '../views/authorization/ForgotPassword.vue'
import Profile from '../views/users/Profile.vue'
import Homepage from '../views/Homepage.vue'
import Users from '../views/users/Users.vue'
import CreateEvent from "@/views/events/CreateEvent"
import Going from "@/views/events/Going"
import Hosting from "@/views/events/Hosting"
import Past from "@/views/events/Past"
import EventDetailsComponent from "@/components/events/EventDetailsComponent";
import Event from "@/views/events/Event";
import ParticipantsContainer from "@/components/users/ParticipantsContainer";


const routes = [
    {
        path: '/signup',
        name: 'signup',
        component: SignUp
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    },
    {
        path: '/forgot-password',
        name: 'forgot-password',
        component: ForgotPassword
    },
    {
        path: '/profile',
        name: 'profile',
        component: Profile,
    },
    {
        path: '/users',
        name: 'users',
        component: Users,
    },
    {
        path: '/',
        name: 'homepage',
        component: Homepage,

    },
    {
        path: '/event/:eventId',
        component: Event,
        props: true,
        children: [
            {
                path: '',
                name: 'event',
                component: EventDetailsComponent
            },
            {
                path: '/participants',
                name: 'participants',
                component: ParticipantsContainer
            }
        ]
    },
    {
        path: '/create',
        name: 'create',
        component: CreateEvent
    },
    {
        path: '/going',
        name: 'going',
        component: Going
    },
    {
        path: '/hosting',
        name: 'hosting',
        component: Hosting
    },
    {
        path: '/past',
        name: 'past',
        component: Past
    }
]

export default routes