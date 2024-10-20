import {UserService} from "../../service/usuario-service.js";

const userService = new UserService();

async function setupPageListResidues() {
    const users = await userService.getUsers();

    console.log(users)
}


window.addEventListener("load", setupPageListResidues);