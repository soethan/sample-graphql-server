mutation newAuthor {
  newAuthor(firstName: "Author", lastName: "666") {
    id
    firstName
    lastName
  }
}

mutation newBook {
  newBook(title: "Book 222", isbn: "22222", pageCount: 222, author: 2) {
    id
    title
    author {
      id
      firstName
      lastName
    }
    pageCount
  }
}

mutation updateBookPageCount {
  updateBookPageCount(id: 7, pageCount: 777) {
    id
    title
    isbn
    pageCount
  }
}

mutation deleteBook {
  deleteBook(id: 9)
}

query authorQuery {
  countAuthors
  findAllAuthors {
    id
    firstName
    lastName
  }
  findAuthorById(id: 1) {
    id
    firstName
    lastName
  }
  findAuthorByFirstName(name: "Steven") {
    firstName
    lastName
  }
}

query bookQuery {
  countBooks
  findAllBooks {
    id
    title
    isbn
    author {
      firstName
      lastName
    }
    pageCount
  }
  findBookById(id: 7) {
    id
    title
    pageCount
  }
}
