export interface BaseUser {
    username: string,
}

export interface LoginUser {
    identifier: string,
    password: string,
}

export interface RegisterUser extends BaseUser {
    password: string,
    email: string,
    first_name: string,
    last_name: string,
}

export interface User extends BaseUser {
    id: number,
}
