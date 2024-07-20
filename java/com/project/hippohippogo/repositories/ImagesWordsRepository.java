package com.project.hippohippogo.repositories;

import com.project.hippohippogo.entities.ImageWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImagesWordsRepository extends JpaRepository<ImageWord,Long> {

    // Delete all entries of this doc_id from this indexer
    @Query(value = "DELETE FROM images_words WHERE doc_id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteEntriesOfimageId(int doc);

    // Check if doc_id is indexed before or not
    @Query(value = "SELECT EXISTS(SELECT * from images_words WHERE doc_id=?1)", nativeQuery = true)
    int checkIfimageExists(int doc);

    // Return list with word and distinct documents containing it
    @Query(value = "SELECT DISTINCT doc_id FROM images_words WHERE word = ?1", nativeQuery = true)
    List<Integer> getDocIdContainingWord(String word);

    // Return word count in specific document
    @Query(value = "SELECT COUNT(*) FROM images_words WHERE word = ?1 and doc_id = ?2", nativeQuery = true)
    int getWordCountInDoc(String word,int doc);
}