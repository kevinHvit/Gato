import express from 'express';
import {PORT} from './config.js';
import  indexRoutes from './routes/index.routes.js';
import clientRoutes from './routes/clients.routes.js';


const app = express ();
app.use(express.json());


app.use(indexRoutes);
app.use(clientRoutes);

app.listen(PORT);
console.log(`Server is listening on port ${PORT}`);














