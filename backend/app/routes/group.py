from fastapi import APIRouter

router = APIRouter()

@router.get("/")
def get_users():
    return {"message": "그룹 리스트"}