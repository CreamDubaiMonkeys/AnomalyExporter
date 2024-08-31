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
    created_at: string,
    updated_at: string
}

export interface RegisterEvent extends BaseEvent {
    creatorId: number,
}
