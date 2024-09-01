import { User } from "./user"

export interface BaseEvent{
    capacity: number,
    date: string,
    time: string,
    description: string,
    title: string,
    is_private: boolean,
    location: string,
    participents: string[]
}

export interface Event extends BaseEvent {
    id: number,
    creator: User,
    created_at: string,
    updated_at: string
}

export interface RegisterEvent extends BaseEvent {
    creatorId: number,
}
