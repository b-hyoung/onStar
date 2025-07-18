# backend/app/routes/user.py
from fastapi import APIRouter

router = APIRouter()

@router.get("/users")
def get_users():
    return {"message": "사용자 리스트"}