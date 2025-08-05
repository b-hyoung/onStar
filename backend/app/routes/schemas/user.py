from pydantic import BaseModel, EmailStr

class UserCreate (BaseModel):
    username: str
    password : str
    password_confirm: str
    email : EmailStr

class UserLogin (BaseModel):
    email:EmailStr
    password:str

class SignUserResponse(BaseModel):
    id : int
    username:str
    email:EmailStr

    class Config:
        orm_mode = True