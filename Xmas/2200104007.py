# coding: utf-8
"""
This is a script that uses BRTScore to determine
which of the two given sentences is Christmas-ish.

Created by Riku Iikura on 2020/12/25.
"""
import bert_score
import argparse


def calc_bert_score(cands, refs):
    """
    A function for calculating BERTScore.

    Args:
        cands ([List[str]]): candidate sentence
        refs ([List[str]]): reference sentence

    Returns:
        [(List[float], List[float], List[float])]: [(Precision, Recall, F1)]
    """
    Precision, Recall, F1 = bert_score.score(cands, refs, lang="en", verbose=True)
    return F1.numpy().tolist()


def main():
    parser = argparse.ArgumentParser(description='This is a script that uses BRTScore to determine which of the two given sentences is Christmas-ish.')

    parser.add_argument('-sent_1', '--sentence_1', help='Sentence 1 (e.g. Santa Claus gave me a present.)', required=True, type=str)
    parser.add_argument('-sent_2', '--sentence_2', help='Sentence 2 (e.g. I like a dog.)', required=True, type=str)

    args = parser.parse_args()

    Christmas_score_1 = calc_bert_score(['Merry Christmas !'], [args.sentence_1])
    Christmas_score_2 = calc_bert_score(['Merry Christmas !'], [args.sentence_2])

    print('Sentence 1: {0} (Christmas-ish score: {1})'.format(args.sentence_1, Christmas_score_1))
    print('Sentence 2: {0} (Christmas-ish score: {1})'.format(args.sentence_2, Christmas_score_2))

    if Christmas_score_1 == Christmas_score_2:
        print('Sentence 1 and Sentence 2 are both Christmas-ish')
    elif Christmas_score_1 > Christmas_score_2:
        print('Sentence 1 is more Christmas-ish than Sentence 2.')
    else:
        print('Sentence 2 is more Christmas-ish than Sentence 1.')


if __name__ == "__main__":
    main()
