import axios from "../costum-axios/axios";

const Library={
    fetchCategories:()=>{
        return axios.get("/categories");
    },
    fetchBooks:()=>{
        return axios.get("/books");
    },
    fetchAuthors:()=>{
        return axios.get("/authors");
    },
    addBook:(name,category,author,availableCopies)=>{
        return axios.post("/books/add",{
            "name":name,
            "category":category,
            "authorid":author,
            "availableCopies":availableCopies
        });

    },
    editBook:(id,name,category,author,availableCopies) =>{
        return axios.put(`/books/edit/${id}`,{
            "name": name,
            "category": category,
            "authorid": author,
            "availableCopies":availableCopies
        });
    },
    getBook: (id) =>{
        return axios.get(`/books/${id}`);
    },
    deleteBook: (id) =>{
        return axios.delete(`/books/delete/${id}`);
    },
    decreaseCopies:(id) =>{
        return axios.get(`/books/${id}/decreasecopies`);
    }
}
export default Library;