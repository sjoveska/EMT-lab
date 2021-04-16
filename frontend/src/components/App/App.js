import './App.css';
import React,{Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from "react-router-dom";
import LibraryRepository from "../../repository/libraryRepository";
import Categories from "../categories/categories";
import Books from "../books/bookList/books";
import BookAdd from "../books/bookAdd/bookAdd";
import BookEdit from "../books/BookEdit/bookEdit";
import Header from "../Header/header"

class App extends Component{
    constructor(props) {
    super(props);
    this.state={
        categories:[],
        authors:[],
        countries:[],
        books:[],
        selectedBook:{}


    }
    }
    componentDidMount() {
        this.loadCategories();
        this.loadBooks();
        this.loadAuthors();
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className={"container"}>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories} />}/>
                       <Route path={"/books/add"} exact render={()=>
                           <BookAdd categories={this.state.categories}
                                    authors={this.state.authors}
                                    onBookAdd={this.addBook}/>}/>

                        <Route path={"/books/edit/:id"} exact render={()=>
                            <BookEdit categories={this.state.categories}
                                      authors={this.state.authors}
                                      book={this.state.selectedBook}
                                      onBookEdit={this.editBook}/>}/>
                        <Route path={"/books"} exact render={()=>
                            <Books books={this.state.books}
                                   onDelete={this.deleteBook}
                                   onMarkasTaken={this.decreaseCopies}
                                   onEdit={this.getBook}/>}/>

                        <Redirect to={"/books"}/>

                    </div>

                </main>
            </Router>

        );
    }
    loadCategories = () =>{
        LibraryRepository.fetchCategories().then((data)=>{
            this.setState({
                categories: data.data
            })
        });
    }
    loadBooks = () =>{
        LibraryRepository.fetchBooks().then((data) =>{
            this.setState({
                books:data.data
            })
        });
    }
    loadAuthors= () =>{
        LibraryRepository.fetchAuthors().then((data)=>{
            this.setState({
                authors:data.data
            })
        })
    }
    addBook=(name,category,author,availableCopies)=>{
        LibraryRepository.addBook(name,category,author,availableCopies)
            .then(()=> {
                this.loadBooks();
            });

    }
    editBook =(id,name,category,author,availableCopies)=>{
        LibraryRepository.editBook(id,name,category,author,availableCopies)
            .then(()=>{
                this.loadBooks();
            });
    }
    getBook=(id) =>{
        LibraryRepository.getBook(id)
            .then((data)=>{
                this.setState({
                    selectedBook: data.data
                })
            })
    }
    deleteBook =(id) =>{
        LibraryRepository.deleteBook(id)
            .then(()=>{
                this.loadBooks();
            });
    }
    decreaseCopies =(id) =>{
        LibraryRepository.decreaseCopies(id)
            .then(()=>{
                this.loadBooks();
            });
    }


}

export default App;
