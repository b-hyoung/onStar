# backend/app/routes/user.py
from fastapi import APIRouter ,Depends , HTTPException
from sqlalchemy.orm import Session
from app.database import get_db
from app import models, schemas

router = APIRouter()

@router.post('/signup' , response_model=schemas.SignUserResponse)
def signup(user:schemas.UserCreate, db: Session = Depends(get_db)):
    #user id Check
    existing_user = db.query(models.User).filter(models.User.username)
    if existing_user :
        raise HTTPException(status_code=400,detail="이미 사용중인 아이디 입니다.")

    # email check
    existing_email = db.query(models.User).filter(models.User.email == user.email).first()
    if existing_email :
        raise HTTPException(status_code=400,detail = "이미 사용중인 이메일 입니다.")
    
    # password_confirm
    if (user.password == user.password_confirm):
        raise HTTPException(status_code=400 , detail = "비밀번호가 일치하지 않습니다.")
    
    # hashing password
    hashed_password = user.password

    # create user
    new_user = models.User(
        username = user.username,
        password = user.password,
        email = user.email,
    )
    db.add(new_user)
    db.commit()
    db.refresh(new_user)

    return new_user

