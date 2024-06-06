import { pool } from "../../db.js";



export const getClients = async (req, res) => {
    try {
        const [resul] = await pool.query("select * from client");
        res.json(resul);
        //console.log(resul);
    }
    catch (error) {
       return res.status(500).json({massage:error.message});
    }
}

export const getClient = async (req, res) => {
   
   try {
    const [resul] = await pool.query("select *from client where id= ?",
        [req.params.id]);

    res.json(resul);
   } catch (error) {
    return res.status(500).json({massage:error.message});
   }
    
}

export const createClient = async (req, res) => {

    try {
        const { name, lastname1, lastname2,email,password, telefono,fk_id_role } = req.body;
        const resul = await pool.query(" insert into client(name, lastname1, lastname2,email,password, telefono,fk_id_role) values (?,?,?,?,?,?,?)",
            [name, lastname1, lastname2,email,password, telefono,fk_id_role ]);
        //console.log([resul]);
        res.send('creando clientes');
        

    }
    catch (error) {
        return res.status(500).json({massage:error.message});
        
    }

}
export const updateClient =  async (req, res) => {
    try {
        const resul = await pool.query("update client set ? where id = ?",
        [   req.body,
            req.params.id]);
            res.json(resul);
    //res.send('u');
    } catch (error) {
        return res.status(500).json({massage:error.message});
    }
    
}
export const deleteClient = async (req, res) => {
    try  {  
        const [resul] = await pool.query("delete *from client where id= ?",
        [req.params.id]);

        if(resul.affectedRows===0)
            return res.status(404).json({message: "Client not found"})
        return res.sendStatus(204);
        //res.json(resul);


    }
    catch(error){

        return res.status(500).json({massage:error.message})

    }

  
}


